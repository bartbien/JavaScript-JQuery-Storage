<?php
//vars

if(isset($_POST['submit'])){
    $subject = $_POST['subject'];

    $to = "sample@mail.pl";

    $from = $_POST['email'];

//data
    $msg = "NAME: "  .$_POST['name']    ."<br>\n";
    $msg .= "EMAIL: "  .$_POST['email']    ."<br>\n";
    $msg .= "WEBSITE: "  .$_POST['web']    ."<br>\n";
    $msg .= "COMMENTS: "  .$_POST['comments']    ."<br>\n";

//Headers
    $headers  = "MIME-Version: 1.0\r\n";
    $headers .= "Content-type: text/html; charset=UTF-8\r\n";
    $headers .= "From: <".$from. ">" ;

// insert with your SMTP

    mail ($to, $subject,$msg, $headers);
    echo "sent";
}
?>


<form id="contactForm" action="" method="post">
    <fieldset>
        <p>
            <label for="name" >Name</label>
            <input name="name"  id="name" type="text" class="form-poshytip" title="Enter your full name" />
        </p>
        <p>
            <label for="email" >Email</label>
            <input name="email"  id="email" type="text" class="form-poshytip" title="Enter your email address" />
        </p>
        <p>
            <label for="web">Website</label>
            <input name="web"  id="web" type="text" class="form-poshytip" title="Enter your website" />
        </p>
        <p>
            <label for="comments">Message</label>
            <textarea  name="comments"  id="comments" rows="5" cols="20" class="form-poshytip" title="Enter your comments"></textarea>
        </p>
        <!-- send mail configuration -->
        <input type="hidden" value="Email received from Website" name="subject" id="subject" />

        <!-- ENDS send mail configuration -->

        <p><input type="submit" value="Send" name="submit" id="submit" /> <span id="error" class="warning">Message</span></p>
    </fieldset>

</form>