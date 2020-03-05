<form method="post" action="StudentRegistrationForm">
  <div class="container">
    <h1>Register</h1>
    <p>Please fill in this form.</p>
    <hr>
    <label for="rollNumber"><b>Roll Number</b></label>
    <input type="text" placeholder="Enter Roll Number" name="studentRollNumber" required>

    <label for="name"><b>Name</b></label>
    <input type="text" placeholder="Enter Name" name="studentName" required>

     <label for="University"><b>University Name</b></label>
     <input type="text" placeholder="Enter University Name" name="studentUniversity" required>

    <button type="submit">Register</button>
  </div>


</form>
<form method="get" action="StudentRegistrationSearch">
  <div class="container">
        <h1>Search Student Details</h1>
        <p>Please Enter Student Roll Number.</p>
        <hr>
        <label for="rollNumber"><b>Roll Number</b></label>
        <input type="text" placeholder="Enter Roll Number" name="studentSearchRollNumber" required>
        <button type="search">Search</button>
      </div>
</form>

</form>
<form method="get" action="PropertyFileReader">
  <div class="container">
        <button type="submit">Reader</button>
   </div>
</form>
