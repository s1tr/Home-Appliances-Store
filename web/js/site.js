


function validateAddnewAppliance() {
    
//    error variable
    let errtype = document.querySelector('#err-type');
    let errmodel = document.querySelector('#err-model');
    let erryear = document.querySelector('#err-year');
    let errmanufacturer = document.querySelector('#err-manufacturer');
    let errdescription = document.querySelector('#err-description');
    let errcount = document.querySelector('#err-count');
    let errprice = document.querySelector('#err-price');


//    define valid by true to check errors
    var valid = true;

//    check the validation of type
    if ((document.querySelector('#tv').checked == false) && (document.querySelector('#wm').checked == false) && (document.querySelector('#rf').checked == false)) {
        valid = false;
        // validateall[0].push(false)
        errtype.innerHTML = "please select the type of the product!";
        errtype.style.display = "inline";
    }
    else {
        errtype.innerHTML = "";
        errtype.style.display = "none";
    }



//    check if user not select any model
    if (document.querySelector('#model').value == "Please select the item type...") {
        valid = false;
        errmodel.innerHTML = "select the item type!";
        errmodel.style.display = "inline";
    }
    else {
        errmodel.innerHTML = "";
        errmodel.style.display = "none";
    }


//    check if the year is empty
    if (document.querySelector('#year').value == "") {
        erryear.innerHTML = "";
        erryear.style.display = "none";
    }
    else { 
        //check validation of year that is must be between 1990-2022
        var yearvalue = document.querySelector('#year').value;
        if ((yearvalue > 1990) && (yearvalue <= 2022)) { 
            erryear.innerHTML = "";
            erryear.style.display = "none";
        }
        else {
            valid = false;
            erryear.innerHTML = "the year must be greater than 1990 and less than 2023!";
            erryear.style.display = "inline";
        }
    }


//    check if user not select any manufacturer
    if (document.querySelector('#manufacturer').value == "Please select the item manufacturer...") {
        valid = false;
        errmanufacturer.innerHTML = "Please select the item manufacturer!";
        errmanufacturer.style.display = "inline";
    }
    else {
        errmanufacturer.innerHTML = "";
        errmanufacturer.style.display = "none"
    }

//    check if the description is empty
    if (document.querySelector('#description').value == "") {
        errdescription.innerHTML = "";
        errdescription.style.display = "none";
    }
    else { //description must be only letters and numbers
        if (document.querySelector('#description').value.search(/^[A-Za-z_0-9\s]{0,200}$/)) {
            valid = false;
            errdescription.innerHTML = "Description must be letters and numbers only and no longer than 1000!";
            errdescription.style.display = "inline";
        }
        else {
            errdescription.innerHTML = "";
            errdescription.style.display = "none";
        }
    }


//    check if the count is empty
    if ((document.querySelector('#count').value == "")) {
        valid = false;
        errcount.innerHTML = "the count field must not be empty!";
        errcount.style.display = "inline";
    }
    else { // count must be between 0 to 100
        var countvalue = document.querySelector('#count').value;
        if ((countvalue > 0) && (countvalue <= 100)) {
            errcount.innerHTML = "";
            errcount.style.display = "none";
        }
        else {
            valid = false;
            errcount.innerHTML = "The count field must not be less than 1 and not more than 100!";
            errcount.style.display = "inline";
        }
    }


//    check if the price is empty
    if (document.querySelector('#price').value == "") {
        valid = false;
        errprice.innerHTML = "the price field must not be empty!";
        errprice.style.display = "inline";
    } // price must not grater than 10milion
    else if (document.querySelector('#price').value > 100000000) {
        valid = false;
        errprice.innerHTML = "the price field must not be grater than 10milion!";
        errprice.style.display = "inline";
    } else {
        errprice.innerHTML = "";
        errprice.style.display = "none";
    }
    
    
    






//    if not error that means valid var is true
    if (valid == false) {
        return false;    
    }
    else {
        return true;    
    }
}










function validateFeedback() {

    var valid2 = true;


//    error variable
    let errname = document.querySelector('#err-name');
    let erremail = document.querySelector('#err-email');
    let errphone = document.querySelector('#err-phone');
    let errreqtype = document.querySelector('#err-reqtype');
    let errsubject = document.querySelector('#err-subject');
    let errmessage = document.querySelector('#err-message');




//    check if the name has any thing except the letters
    if (document.querySelector('#name').value.search(/^[A-Za-z\s]{0,30}$/)) {
        valid2 = false;
        errname.innerHTML = "name must not contain numbers and at least 30 letter !";
        errname.style.display = "inline";
    }
//    check if the name is empty
    else if (document.querySelector('#name').value == "") {
        valid2 = false;
        errname.innerHTML = "name must not be empty !";
        errname.style.display = "inline";
    }
    else {
        errname.innerHTML = "";
        errname.style.display = "none";
    }



//    check for email validation
    if (document.querySelector('#email').value.search(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/) != 0) {
        valid2 = false;
        erremail.innerHTML = "the format of your email on not currect: email@domain.com !"
        erremail.style.display = "inline";
    }
    else {
        erremail.innerHTML = ""
        erremail.style.display = "none";
    }






//    check for phone number validation
//if the number is not starting with 05 or the number is greater than 10 digit, print error
    if (document.querySelector('#phone').value.search(/^(05\d{8}) || $/)) {
        valid2 = false;
        errphone.innerHTML = "the phone number format is not currect, 10 numbers only: 05** or 9665** !";
        errphone.style.display = "inline";
    }
    else {
        errphone.innerHTML = "";
        errphone.style.display = "none";
    }






//    the requst type must bt letter and number and not exceuding 30 charachter
    if (document.querySelector('#reqtype').value.search(/^[A-Za-z\s]{1,30}$/)) {
        valid2 = false;
        errreqtype.innerHTML = "request type must be only letters,not empty, and not greater than 50 charachter!";
        errreqtype.style.display = "inline";
    }
    else {
        errreqtype.innerHTML = "";
        errreqtype.style.display = "none";
    }




//    the subject must be only letters and numbers and not grater than 30 digit
    if (document.querySelector('#subject').value.search(/^[A-Za-z_0-9\s]{1,30}$/)) {
        valid2 = false;
        errsubject.innerHTML = "subject must be not empty,only letters and numbers!";
        errsubject.style.display = "inline";
    }
    else {
        errsubject.innerHTML = "";
        errsubject.style.display = "";
    }


//    check if the message is empty
    if (document.querySelector('#message').value == "") {
        valid2 = false;
        errmessage.innerHTML = "the message is empty!";
        errmessage.style.display = "inline";
    }
    else {
        errmessage.innerHTML = "";
        errmessage.style.display = "none";
    }



//    if not error that means valid2 var is true
    if (valid2 == false) {
        return false;    
    }
    else {
        return true;     
    }
}

function validatelogin() {

    valid3 = true;
    
//    error variable
    let erremail = document.querySelector('#err-email');
    let errpass = document.querySelector('#err-pass');

//    email validation
    if (document.querySelector('#email').value.search(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/) != 0) {
        valid3 = false;
        erremail.innerHTML = "the format of your email on not currect: example.domain.somthing !"
        erremail.style.display = "inline";
    }
    else {
        erremail.innerHTML = ""
        erremail.style.display = "none";
    }
    
//    password validation to chick if the password is empty or the length of password is greater than 200
    if((document.querySelector('#password').value =="") || (document.querySelector('#password').value.length > 200)){
        valid3 = false;
        errpass.innerHTML = "the password must be not empty and not grater than 200!!"
        errpass.style.display = "inline";
    }
    else{
        errpass.innerHTML = "";
        errpass.style.display ="none";
    }
    
    
    

    if (valid3 == false) {
        return false;    // don't submit the form data to the server because of any validation error(s)
    }
    else {
        return true;     // submit the form data to the server because all data looks correct without errors
    }

}


function validateregister(){
    
    var valid3 = true;
    
//    error variable
    let errfullname = document.querySelector('#err-fullname');
    let erremail = document.querySelector('#err-email');
    let errpassword = document.querySelector('#err-pass');
    let errconfirmPass = document.querySelector('#err-confpass');
    
    
    
//    validate the name to chick if the name is empty or the length of name is greater than 30
    if(document.querySelector('#fullname').value.search(/^[A-Za-z_\s]{1,30}$/)){
        valid3 = false;
        errfullname.innerHTML = "the name must be letter and not greater than 30";
        errfullname.style.display = "inline";   
    }
    else{
        errfullname.innerHTML = "";
        errfullname.style.display = "none";
    }
    
    
//    validate the email as example@doman.com
    if(document.querySelector('#email').value.search(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/) != 0){
        valid3 = false;
        erremail.innerHTML = "the format of your email on not currect: example.domain.somthing !";
        erremail.style.display = "inline";
    }
    else{
        erremail.innerHTML = "";
        erremail.style.display = "none";
    }
    
    //check the validate of the password
    //if the password length is greater than 30 or less than 8
    if(document.querySelector('#password').value.length > 30 || document.querySelector('#password').value.length < 8){
        valid3 = false;
        errpassword.innerHTML = "the length of password must be between 8 to 30";
        errpassword.style.display = "inline";
        errconfirmPass.innerHTML = " **";
        errconfirmPass.style.display = "inline";
    }
    //if the password field is empty 
    else if(document.querySelector('#password').value == ""){
        valid3 = false;
        errpassword.innerHTML = "the password must be not empty";
        errpassword.style.display = "inline";
        
        errconfirmPass.innerHTML = "Passwords don’t match";
        errconfirmPass.style.display = "inline";
    }
    //if both of the twos passwords is not match
    else if(document.querySelector('#password').value != document.querySelector('#confpassword').value){
        valid3 = false;
        errpassword.innerHTML = "";
        errpassword.style.display = "none";
        
        errconfirmPass.innerHTML = "Passwords don’t match";
        errconfirmPass.style.display = "inline";
    }
    else{
        errconfirmPass.innerHTML = "";
        errconfirmPass.style.display = "none";
    }
        
    
    
    //a
    if(valid3 == false){
        return false;
    }
    else{
        return true;
    }
    }  
