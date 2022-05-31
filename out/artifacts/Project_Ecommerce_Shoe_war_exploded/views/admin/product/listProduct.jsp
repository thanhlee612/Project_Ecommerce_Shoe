<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Bootstrap CRUD Data Table for Database with Modal Form</title>
<link rel="stylesheet" href="/template/admin/assets/css/style.css">
</head>

<body>
	
		<div class="main-content">
		<form action="<c:url value='/admin-product'/>" id="formSubmit"
		method="get">
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
								chủ</a></li>
					</ul>
					<!-- /.breadcrumb -->
				</div>
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">

							<div class="container-xl">
								<div class="table-responsive">
									<div class="table-wrapper">
										<div class="table-title">
											<div class="row">
												<div class="col-sm-6">
													<h2>
														Manage <b>Product</b>
													</h2>
												</div>
												<div class="col-sm-6">
													<a href="#addEmployeeModal" class="btn btn-success"
														data-toggle="modal"><i class="material-icons">&#xE147;</i>
														<span>Add New Employee</span></a> <a
														href="#deleteEmployeeModal" class="btn btn-danger"
														data-toggle="modal"><i class="material-icons">&#xE15C;</i>
														<span>Delete</span></a>
												</div>
											</div>
										</div>
										<table class="table table-striped table-hover">
											<thead>
												<tr>
													<th><span class="custom-checkbox"> <input
															type="checkbox" id="selectAll"> <label
															for="selectAll"></label>
													</span></th>
													<th>Id</th>
													<th>Tên sản phẩm</th>
													<th>Hình ảnh</th>
													<th>Giá</th>
													<th>Tiêu đề</th>
													<th>Mô tả</th>
													<th>Loại</th>
													<th>Hành động</th>
												</tr>
											</thead>
											<tbody>
												<%-- <c:forEach items = "${p}" var = "p"> --%>
												<c:forEach items="${models.listResult}" var="p">
													<tr>
														<td><span class="custom-checkbox"> <input
																type="checkbox" id="checkbox1" name="options[]"
																value="1"> <label for="checkbox1"></label>
														</span></td>
														<td>${p.id}</td>
														<td>${p.pname}</td>
														<td><img src="template/web/img/product/${p.image}"
															style="width: 60px; height: 60px"></td>
														<td>${p.price}</td>
														<td>${p.title}</td>
														<td>${p.pdescription}</td>
														<td>${p.cateID}</td>
														<td><a href="#editEmployeeModal" class="edit"
															data-toggle="modal"><i class="material-icons"
																data-toggle="tooltip" title="Edit">&#xE254;</i></a> <a
															href="#deleteEmployeeModal" class="delete"
															data-toggle="modal"><i class="material-icons"
																data-toggle="tooltip" title="Delete">&#xE872;</i></a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>

									</div>
									<div class="clearfix">
										<div class="hint-text">
											Showing <b class="b1"></b> out of <b class="b2"></b> entries
										</div>
										<ul class="pagination" id="pagination"></ul>
										<input type="" value="" id="page" name="page" />
										<input type="" value="" id="maxPageItems" name="maxPageItems" />
										<input type="" value="" id="sortName" name="sortName" />
										<input type="" value="" id="sortBy" name="sortBy" />
									</div>
								</div>
							</div>
						</div>
						<!-- Edit Modal HTML -->
						<div id="addEmployeeModal" class="modal">
							<div class="modal-dialog">
								<div class="modal-content">
									<form>
										<div class="modal-header">
											<h4 class="modal-title">Add Employee</h4>
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
										</div>
										<div class="modal-body">
											<div class="form-group">
												<label>Name</label> <input type="text" class="form-control"
													required>
											</div>
											<div class="form-group">
												<label>Email</label> <input type="email"
													class="form-control" required>
											</div>
											<div class="form-group">
												<label>Address</label>
												<textarea class="form-control" required></textarea>
											</div>
											<div class="form-group">
												<label>Phone</label> <input type="text" class="form-control"
													required>
											</div>
										</div>
										<div class="modal-footer">
											<input type="button" class="btn btn-default"
												data-dismiss="modal" value="Cancel"> <input
												type="submit" class="btn btn-success" value="Add">
										</div>
									</form>
								</div>
							</div>
						</div>
						<!-- Edit Modal HTML -->
						<div id="editEmployeeModal" class="modal">
							<div class="modal-dialog">
								<div class="modal-content">
									<form>
										<div class="modal-header">
											<h4 class="modal-title">Edit Employee</h4>
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
										</div>
										<div class="modal-body">
											<div class="form-group">
												<label>Name</label> <input type="text" class="form-control"
													required>
											</div>
											<div class="form-group">
												<label>Email</label> <input type="email"
													class="form-control" required>
											</div>
											<div class="form-group">
												<label>Address</label>
												<textarea class="form-control" required></textarea>
											</div>
											<div class="form-group">
												<label>Phone</label> <input type="text" class="form-control"
													required>
											</div>
										</div>
										<div class="modal-footer">
											<input type="button" class="btn btn-default"
												data-dismiss="modal" value="Cancel"> <input
												type="submit" class="btn btn-info" value="Save">
										</div>
									</form>
								</div>
							</div>
						</div>
						<!-- Delete Modal HTML -->
						<div id="deleteEmployeeModal" class="modal">
							<div class="modal-dialog">
								<div class="modal-content">
									<form>
										<div class="modal-header">
											<h4 class="modal-title">Delete Employee</h4>
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
										</div>
										<div class="modal-body">
											<p>Are you sure you want to delete these Records?</p>
											<p class="text-warning">
												<small>This action cannot be undone.</small>
											</p>
										</div>
										<div class="modal-footer">
											<input type="button" class="btn btn-default"
												data-dismiss="modal" value="Cancel"> <input
												type="submit" class="btn btn-danger" value="Delete">
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			</form>
		</div>
		<!-- /.main-content -->
	
	<script type="text/javascript">
	var totalPages = ${models.totalPage};
	var currentPage = ${models.page};
	var limit = 5;
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPages,
				visiblePages : 5,
				startPage : currentPage,
				onPageClick : function(event, page) {	
					if(currentPage != page){
						$("#page").val(page);
						$("#maxPageItems").val(limit);
						$("#sortName").val('id');
						$("#sortBy").val('desc');
						$("#formSubmit").submit();
					}
					
				}
			});
		});
	</script>
</body>

</html>