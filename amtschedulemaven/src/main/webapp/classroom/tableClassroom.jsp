<%@page import="java.util.List"%>
<%@page import="com.amt.schedule.entities.Classroom"%>

<style>
.dataTables_filter {
	float: right;
	text-align: left;
}
</style>
<div class="table-responsive">
	<table class="table table-bordered table-hover table-dark"
		id="dataTable">
		<thead>
			<tr>
				<th class="text-center">Numero</th>
				<th class="text-center">Nom</th>
			</tr>
		</thead>

		<tbody>
			<%
						@SuppressWarnings("unchecked")
									List<Classroom> classrooms = (List<Classroom>)request.getAttribute("classroom");
									for(Classroom classroom : classrooms){
					%>
			<tr class="note">
				<td class="code text-center"><%= classroom.getNumero() %></td>
				<td class="text-center"><%= classroom.getName() %></td>
			</tr>
			<%
						}
						%>
		</tbody>
	</table>
</div>

<script>
	$(function() {
		var tab = [];
		var t = $('#dataTable').DataTable({
			columns : [ {
				title : 'Numero'
			}, {
				title : 'Nom'
			} ],
			info : false,
			lengthChange : false,
			scollX : false,
			scrollY : 400,
			scrollCollapse : true,
			paging : false,
		});

		$('#dataTable tbody').on('click', 'tr', function() {
			if ($(this).hasClass('selected')) {
				$(this).removeClass('selected');
			} else {
				t.$('tr.selected').removeClass('selected');
				$(this).addClass('selected');
			}

			var texte = $('.selected').text();
			tab = texte.replace(/\t/g, '').split('\n');
			populate_calendar(tab);
		});

		function populate_calendar(tab) {
			$('#calendar')
					.replaceWith(
							'<div id="calendar" class="col-md-9 float-right border"><div style="clear: both"></div>');
			$.ajax({
				url : 'times?criteria=classroom&key=' + tab[1],
				dataType : 'xml',
				type : 'GET',
				success : function(doc) {
					var eventsArr = [];
					if ($(doc).find('lecture').length > 0) {
						$(doc).find('lecture').each(
								function() {
									eventsArr.push({
										id : $(this).find('id').html(),
										title : $(this).find('ens').html()
												+ '\n'
												+ $(this).find('titre').html(),
										start : $(this).find('debut').html(),
										end : $(this).find('fin').html(),
										allDay : false,
										className : 'important'
									});
								});
					}
					initialize(eventsArr);
				}
			});
		}

		populate_calendar([ "root", 1 ]);
	});
</script>
