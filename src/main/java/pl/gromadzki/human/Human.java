package pl.gromadzki.human;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

@Component
public class Human {
    private final String name;
    private final String surname;
    private final String gender;
    private final String region;
    private final Integer age;
    private final String phoneNumber;
    private final Date birthday;
    private final String email;
    private final String imageUrl;

    @Autowired
    public Human(){
        String name = "";
        String surname = "";
        String gender = "";
        String region = "";
        Integer age = 0;
        String phoneNumber = "";
        Date birthday = new Date();
        String email = "";
        String imageUrl = "";

        try {
            JSONObject jsonObject = generateJSON();
            name = jsonObject.getString("name");
            surname = jsonObject.getString("surname");
            gender = jsonObject.getString("gender");
            region = jsonObject.getString("region");
            age = jsonObject.getInt("age");
            phoneNumber = jsonObject.getString("phone");
            birthday = new SimpleDateFormat("dd/MM/yyyy").parse(jsonObject.getJSONObject("birthday").getString("dmy"));
            email = jsonObject.getString("email");
            imageUrl = jsonObject.getString("photo");
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.region = region;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.email = email;
        this.imageUrl = imageUrl;
    }


    private JSONObject generateJSON() throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        String addres = "https://uinames.com/api/?ext";
        URL url = new URL(addres);
        Scanner scanner = new Scanner(url.openStream());

        while (scanner.hasNext()){
            stringBuilder.append(scanner.nextLine());
        }

        return new JSONObject(String.valueOf(stringBuilder));
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    public String getRegion() {
        return region;
    }

    public Integer getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void cos(){
        System.out.println(getName());
        System.out.println(getSurname());
        System.out.println(getGender());
        System.out.println(getAge());
        System.out.println(getRegion());
        System.out.println(getPhoneNumber());
        System.out.println(getBirthday().toString());
        System.out.println(getEmail());
        System.out.println(getImageUrl());
    }
}
