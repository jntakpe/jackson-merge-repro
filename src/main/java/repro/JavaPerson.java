package repro;

import com.fasterxml.jackson.annotation.JsonMerge;

class JavaPerson {

    private String username;

    @JsonMerge
    private JavaAddress address;

    public String getUsername() {
        return username;
    }

    public JavaPerson setUsername(String username) {
        this.username = username;
        return this;
    }

    public JavaAddress getAddress() {
        return address;
    }

    public JavaPerson setAddress(JavaAddress address) {
        this.address = address;
        return this;
    }
}
