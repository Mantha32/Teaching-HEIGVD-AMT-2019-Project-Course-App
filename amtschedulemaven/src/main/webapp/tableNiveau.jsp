<%@page import="java.util.List"%>
<%@page import="com.amt.schedule.entities.Niveau"%>

<div class="table-responsive">
	<table class="table table-bordered table-hover table-dark"
		id="dataTable">
		<thead>
			<tr>
				<th class="text-center">Niveau</th>
			</tr>
		</thead>

		<tbody>
			<%
						@SuppressWarnings("unchecked")
									List<Niveau> niveaux = (List<Niveau>)request.getAttribute("niveaux");
									for(Niveau niv : niveaux){
					%>
			<tr class="note">
				<td class="code text-center"><%= niv.getNiveau() %></td>
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
				title : 'Niveau'
			} ],
			info : false,
			lengthChange : false,
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
			populate_calendar();
		});

		function populate_calendar() {
			$('#calendar')
					.replaceWith(
							'<div id="calendar" class="col-md-9 float-right border"><div style="clear: both"></div>');
			$.ajax({
				url : 'cours?criteria=niveau&key=' + tab[1],
				dataType : 'xml',
				type : 'GET',
				success : function(doc) {
					var eventsArr = [];
					if ($(doc).find('ue').length > 0) {
						$(doc).find('ue').each(
								function() {
									eventsArr.push({
										id : $(this).find('id').html(),
										title : $(this).find('ens').html()
												+ '\n'
												+ $(this).find('code').html()
												+ '\n'
												+ $(this).find('salle').html(),
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
	});
</script>
