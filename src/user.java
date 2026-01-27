public class user {
    int user_id;
    String name;
    String email;
    int password;

    @Override
    public String toString() {
        return "user{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password=" + password +
                '}';
    }

    public user(int user_id, String name, String email, int password) {
        this.user_id = user_id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
