(function($, window, document) {
   "use strict";
   
   var loginForm = $("#loginForm");
   var loginError = $("#loginForm #loginError");
   var loginErrorMsg = $("#loginForm #loginError #loginErrorMsg");
   
   var validateLoginForm = function (event) {
      var userName = $("#loginForm #username").val();
      var userPass = $("#loginForm #password").val();
      
      var errorMsgs = [];
      if (userName == null || userName.length <= 0) {
         errorMsgs.push("User name cannot be null or empty string.");
      }
 
      if (userName != null && userName.length > 32) {
         errorMsgs.push("User name is too long. Max 32 characters.");
      }
      
      if (userPass == null || userPass.length <= 0) {
         errorMsgs.push("User password cannot be null or empty string.");
      }

      if (userPass != null && userPass.length < 8) {
         errorMsgs.push("User password is too short. Min 8 characters.");
      }
      
      if (userPass != null && userPass.length > 32) {
         errorMsgs.push("User password is too long. Max 32 characters.");
      }
      
      if (errorMsgs != null && errorMsgs.length > 0) {
         showLoginError(errorMsgs[0]);
         event.preventDefault();
         return false;
      }
      
      return true;
   };
   
   var showLoginError = function(errorMsg) {
      if (errorMsg == null || errorMsg.length <= 0) {
         loginErrorMsg.html("");
         loginError.hide();
      } else {
         loginErrorMsg.html(errorMsg);
         loginError.show();         
      }
   };
   
   $(function () {
      loginForm.submit(validateLoginForm);
   });
   
}(window.jQuery, window, document));