public class ContactItem {

    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    public ContactItem(String firstName, String lastName, String phone, String email){
        verifyIfEmpty(firstName, lastName, phone, email);
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setEmail(email);
    }

    public void verifyIfEmpty(String firstName, String lastName, String phone, String email) {

        if(firstName.equals("") && lastName.equals("") && phone.equals("") && email.equals("")){
            throw new ContactItem.EmptyException("A contact item shall contain at least one of [first name], [last name], [phone number], or [email address]!");
        }

    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public void setEmail(String email){
        this.email = email;
    }


    /*
    private boolean isPhoneValid(String phone){
        return (phone.length() == 12 && phone.charAt(3) == ('-') && phone.charAt(7) == ('-'));
    }
     */

    /*
    private boolean isEmailValid(String email){

        if(!email.equals("")){

            for(int i = 0; i < email.length(); i++){
                if(email.charAt(i) == '@'){
                    for(int j = email.indexOf(email.charAt(i)); j < email.length(); j++){
                        if(email.charAt(j) == '.'){
                            return true;
                        }
                    }

                }
            }
            return false;
        }

        return false;
    }
    */


    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getPhone(){
        return phone;
    }

    public String getEmail(){
        return email;
    }

    /*
    class InvalidPhoneException extends IllegalArgumentException{
        public InvalidPhoneException(String msg){
            super(msg);
        }
    }
    */

    /*
    class InvalidEmailException extends IllegalArgumentException{
        public InvalidEmailException(String msg){
            super(msg);
        }
    }
    */

    class EmptyException extends IllegalArgumentException{
        public EmptyException(String msg){
            super(msg);
        }
    }


}
