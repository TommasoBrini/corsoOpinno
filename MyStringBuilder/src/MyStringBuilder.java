public class MyStringBuilder {

    private String myString;

    public MyStringBuilder() {
        myString = "";
    }

    public MyStringBuilder(String string) {
        myString = string;
    }

    public MyStringBuilder append(String s) {
        myString = myString + s;
        return this;
    }

    public MyString build() {
        return new MyString(this);
    }

    public String getMyString() {
        return myString;
    }
}
