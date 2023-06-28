<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>main tiles</h3>

<table border="1" class="table">
	<tr>
		<th>이름</th>
		<td><input type="text" id ="name" value="홍길동"></td>
	</tr>
		<tr>
		<th>나이</th>
		<td><input type="number" id ="age" value="22"></td>
	</tr>
		<tr>
		<th>점수</th>
		<td><input type="number" id ="score" value="60"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		<button id="saveBtn" class="btn btn-primary">저장</button>
		</td>
	</tr>
</table>

<h3>학생목록</h3>
<table id="list" class="table">
	<thead>
		<tr><th>이름</th><th>나이</th><th>점수</th></tr>
	</thead>
	<tbody id="target">
	</tbody>
	
</table>

<script src="resources/js/main4.js"></script>