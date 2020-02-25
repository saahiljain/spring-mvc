<%@ include file="./header.jspf" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<h2><b>Add Product</b> form</h2>
<hr />

<div class="col">
	<sf:form modelAttribute="PRODUCT" action="save-product" method="POST">
		<div class="form-group row">
			<label class="col-md-4" for="productId">Product ID</label>
			<div class="col-md-8">
				<sf:input path="productId" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group row">
			<label class="col-md-4" for="productName">Product Name</label>
			<div class="col-md-8">
				<sf:input path="productName" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group row">
			<label class="col-md-4" for="productPrice">Product Price</label>
			<div class="col-md-8">
				<sf:input path="productPrice" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group row">
			<label class="col-md-4" for="categoryName">Category Name</label>
			<div class="col-md-8">
				<sf:input path="categoryName" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group row">
			<label class="col-md-4"></label>
			<div class="col-md-8">
				<button class="btn btn-primary">Submit</button>
			</div>
		</div>
	</sf:form>



<%@ include file="./footer.jspf" %>