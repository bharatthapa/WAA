<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Add Product Form</title>
<style type="text/css">
@import url(css/main.css);
</style>
</head>
<body>

	<div id="global">
		<form:form modelAttribute="product" action="product" method="post">
			<fieldset>
				<legend>Add a product</legend>
				<p>
					<form:label path="category">Category </form:label>
					<form:select id="category" path="category.id">
						<form:option value="0">Select Categories</form:option>
						<form:options items ="${categories}" itemLabel="name"
							itemValue="id" />
					</form:select>

				</p>

				<p>
					<form:label path="name">Product Name: </form:label>
					<form:input path="name" tabindex="1" />
				</p>
				<p>
					<form:label path="description">Description: </form:label>
					<form:input value="${product.description}" path="description"
						tabindex="2" />
				</p>
				<p>
					<form:label path="price">Price: </form:label>
					<form:input path="price" tabindex="3" />
				</p>
				<p id="buttons">
					<input id="reset" type="reset" tabindex="4"> <input
						id="submit" type="submit" tabindex="5" value="Add Product">
				</p>
			</fieldset>
		</form:form>
	</div>
</body>
</html>
