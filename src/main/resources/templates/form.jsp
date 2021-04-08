<html>
   <body>
      <form action = "Create" method = "POST">
         Product Name: <input type = "text" name = "productName" value=<%=request.getParameter("productName")%>>
         <br/><br/>
         Manufacturer date : <input type = "date" name = "productDate" value=<%=request.getParameter("productDate")%> />
         <br/><br/>
         Origin: <input type = "text" name = "origin" value=<%=request.getParameter("origin")%> />
         <br/><br/>
         Price: <input type = "number" name = "price" value=<%=request.getParameter("price")%>>
         <br/><br/>
         <input type = "submit" value = "Submit" />
      </form>
   </body>
</html>