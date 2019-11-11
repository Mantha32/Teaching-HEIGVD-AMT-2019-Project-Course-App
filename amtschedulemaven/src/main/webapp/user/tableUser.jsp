<%@page import="java.util.List"%>
<%@page import="com.amt.schedule.entities.User"%>

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
				<th class="text-center">Id</th>
				<th class="text-center">Username</th>
			</tr>
		</thead>

		<tbody>
			<%
						@SuppressWarnings("unchecked")
									List<User> users = (List<User>)request.getAttribute("users");
									for(User user : users){
					%>
			<tr class="note">
				<td class="code text-center"><%= user.getUserid() %></td>
				<td class="text-center"><%= user.getUsername() %></td>
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
				title : 'Id'
			}, {
				title : 'Username'
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
				url : 'times?criteria=user&key=' + tab[1],
				dataType : 'xml',
				type : 'GET',
				success : function(doc) {
					var eventsArr = [];
					if ($(doc).find('lecture').length > 0) {
						$(doc).find('lecture').each(
								function() {
									eventsArr.push({
										id : $(this).find('id').html(),
										title : $(this).find('titre').html()
												+ '\n'
												+ $(this).find('classroom').html(),
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
