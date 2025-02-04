<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<title>Car Search</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<h1>Car Search</h1>
	<input type="text" id="searchQuery" placeholder="Search...">
	<button onclick="searchCar()">Search</button>
	<button onclick="downloadCar()">Download as XML</button>

	<table id="carTable" border="1" style="margin-top: 20px;">
		<thead>
			<tr>
				<th>ID</th>
				<th>Brand</th>
				<th>Length</th>
				<th>Weight</th>
				<th>Velocity</th>
				<th>Color</th>

			</tr>
		</thead>
		<tbody>

		</tbody>
	</table>

	<script>
        function searchCar() {
            const query = document.getElementById("searchQuery").value;
            $.get("http://localhost:8080/CarWebApp/car/search?query=" + query, function(data) {
                const tableBody = $("#carTable tbody");
                tableBody.empty();
                data.forEach(cars => {
                    tableBody.append(`
                        <tr>
                            <td>${cars.id}</td>
                            <td>${cars.Brand}</td>
                            <td>${cars.Length}</td>
                            <td>${cars.Weight}</td>
                            <td>${cars.Velocity}</td>
                            <td>${cars.Color}</td>
                        </tr>
                    `);
                });
            });
            alert('done');
        }

        function downloadCar() {
            const query = document.getElementById("searchQuery").value;
            window.location.href = "http://localhost:8080/CarWebApp/rest/car/download?query=" + query;
        }
    </script>
</body>
</html>