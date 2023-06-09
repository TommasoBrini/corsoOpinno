public class MyString {
    private String myString;

    protected MyString(MyStringBuilder msb){
        this.myString = msb.getMyString();
    }

    public String getMyString() {
        return myString;
    }
}
