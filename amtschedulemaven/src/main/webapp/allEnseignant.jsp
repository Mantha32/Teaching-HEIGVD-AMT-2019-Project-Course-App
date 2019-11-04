<%@page import="java.util.List"%>
<%@page import="com.amt.schedule.entities.Utilisateur"%>

<style>
    .dataTables_filter {
        float: right;
        text-align: left;
    }
</style>
<div class="table-responsive">
    <table class="table table-hover table-dark"
           id="dataTable">
        <thead>
        <tr>
            <th class="text-center">Matricule</th>
            <th class="text-center">Email</th>
            <th class="text-center">Nom</th>
            <th class="text-center">Statut</th>
            <th class="text-center">Sexe</th>
            <th class="text-center">Grade</th>
        </tr>
        </thead>

        <tbody>
        <%
            @SuppressWarnings("unchecked")
            List<Utilisateur> users = (List<Utilisateur>)request.getAttribute("enseignants");
            for(Utilisateur user : users){
        %>
        <tr class="note">
            <td class="code text-center"><%= user.getMatricule() %></td>
            <td class="code text-center"><%= user.getEmail() %></td>
            <td class="text-center"><%= user.getNom() %></td>
            <td class="code text-center"><%= user.getType().getStatut() %></td>
            <td class="code text-center"><%= user.getSexe() %></td>
            <td class="code text-center"><%= user.getGrade() %></td>
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
                title : 'Matricule'
            }, {
                title : 'Email'
            }, {
                title : 'Nom'
            }, {
                title : 'Statut'
            }, {
                title : 'Sexe'
            },{
                title : 'Grade'
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
                url : 'cours?criteria=utilisateur&key=' + tab[1],
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

        populate_calendar([ "root", "root" ]);
    });
</script>
