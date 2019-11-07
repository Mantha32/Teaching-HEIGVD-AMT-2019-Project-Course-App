<%--
  Created by IntelliJ IDEA.
  User: dilifera
  Date: 11/7/19
  Time: 9:35 AM
  To change this template use File | Settings | File Templates.
--%>

        <!-- Divider -->
        <hr class="sidebar-divider">
        <!-- Nav Item - user management Collapse Menu -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
                <i class="fas fa-fw fa-table"></i>
                <span>users</span>
            </a>
            <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <h6 class="collapse-header">schedule Components:</h6>
                    <a class="collapse-item" href="<c:url value="listUser" />" >user list</a>
                    <a class="collapse-item" href="<c:url value="createUser" />" >create user</a>
                </div>
            </div>
