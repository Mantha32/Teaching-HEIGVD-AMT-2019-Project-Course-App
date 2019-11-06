<%--
  Created by IntelliJ IDEA.
  User: dilifera
  Date: 11/6/19
  Time: 9:56 PM
  To change this template use File | Settings | File Templates.
--%>

<section class="col-lg-12 connectedSortable ui-sortable">
    <div class="box-body table-responsive">
        <form action="listCourses" method="post">
            <div id="example1_wrapper" class="dataTables_wrapper form-inline" role="grid">
                <div class="row">
                    <div class="col-xs-2">
                        <button type="submit" name="action" value="edit" class="btn bg-olive btn-block">Edit</button>
                    </div>
                    <div class="col-xs-2">
                        <button type="submit" name="action" value="delete" class="btn bg-olive btn-block">Delete</button>
                    </div>
                </div>
                <table id="example1" class="table table-bordered table-striped dataTable" aria-describedby="example1_info">
                    <thead>
                    <tr role="row">
                        <th class="sorting_asc" role="columnheader" tabindex="0" aria-controls="example1" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Rendering engine: activate to sort column descending" style="width: 10px;"></th>
                        <th class="sorting" role="columnheader" tabindex="0" aria-controls="example1" rowspan="1" colspan="1" aria-label="Browser: activate to sort column ascending" style="width: 60px;">course Name</th>
                        <th class="sorting" role="columnheader" tabindex="0" aria-controls="example1" rowspan="1" colspan="1" aria-label="Platform(s): activate to sort column ascending" style="width: 650px;">course Description</th>
                        <th class="sorting" role="columnheader" tabindex="0" aria-controls="example1" rowspan="1" colspan="1" aria-label="Platform(s): activate to sort column ascending" style="width: 80px;">course owner</th>
                        <th class="sorting" role="columnheader" tabindex="0" aria-controls="example1" rowspan="1" colspan="1" aria-label="Engine version: activate to sort column ascending" style="width: 40px;">Created on</th>
                        <th class="sorting" role="columnheader" tabindex="0" aria-controls="example1" rowspan="1" colspan="1" aria-label="CSS grade: activate to sort column ascending" style="width: 40px;">Modified on</th>
                    </tr>
                    </thead>

                    <tfoot>
                    <tr>
                        <th rowspan="1" colspan="1"></th>
                        <th rowspan="1" colspan="1">course Name</th>
                        <th rowspan="1" colspan="1">course Description</th>
                        <th rowspan="1" colspan="1">course Owner</th>
                        <th rowspan="1" colspan="1">Created by</th>
                        <th rowspan="1" colspan="1">Created on</th>
                        <th rowspan="1" colspan="1">Modified on</th>
                    </tr>
                    </tfoot>
                    <tbody role="alert" aria-live="polite" aria-relevant="all">

                    <c:forEach items="${courses}" var="course">
                        <tr class="odd">
                            <td class=" "><input type="radio" name="courseSelected" value="${course.idcourse}"></td>
                            <td class=" ">${course.title}</td>
                            <td class=" ">${course.description}</td>
                            <td class=" ">${course.author}</td>
                            <td class=" ">${course.createdDate}</td>
                            <td class=" ">${course.lastModificationDate}</td>
                        </tr>
                    </c:forEach>


                    </tbody>
                </table>
                <div class="row">
                    <div class="col-xs-6">
                        <div class="dataTables_info" id="example1_info">Showing ${currentPage} to ${currentPage + recordsPerPage} of ${totalOfcourses} entries</div>
                    </div>


                    <div class="col-xs-6">
                        <div class="dataTables_paginate paging_bootstrap">
                            <ul class="pagination">
                                <c:if test="${currentPage != 1}">
                                    <li class="prev">

                                        <a  href="<c:url value="listCourses?page=${currentPage-1}" />">Previous</a>
                                    </li>
                                </c:if>
                                <c:forEach begin="1" end="${nbPages}" var="page"  >
                                    <c:choose>
                                        <c:when test="${currentPage eq page}">
                                            <li>
                                                <a>${page}</a>
                                            </li>
                                        </c:when>
                                        <c:otherwise>
                                            <li class="active">
                                                <a  href="<c:url value="listCourses?page=${page}" />">${page}</a>
                                            </li>
                                        </c:otherwise>
                                    </c:choose>

                                </c:forEach>
                                <c:if test="${currentPage lt nbPages}">
                                    <li class="next">
                                        <a  href="<c:url value="listCourses?page=${currentPage+1}" />">Next</a>
                                    </li>
                                </c:if>
                            </ul>
                        </div>
                    </div>


                </div>
            </div>
        </form>
    </div>
</section>
