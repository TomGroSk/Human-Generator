package pl.gromadzki.human;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

@Service
public class HumanService {
    private Human human;

    @Autowired
    public HumanService(Human human) {
        this.human = human;
    }

    // TODO Received fatal alert: handshake_failure !! NEED TO FIND HOW TO USE BETTER API
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

    private void setHumanParameter(){
        String name = "";
        String surname = "";
        String gender = "";
        String region = "";
        int age = 0;
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

        human.setName(name);
        human.setSurname(surname);
        human.setGender(gender);
        human.setRegion(region);
        human.setAge(age);
        human.setPhoneNumber(phoneNumber);
        human.setBirthday(birthday);
        human.setEmail(email);
        human.setImageUrl(imageUrl);
    }


    public Human getHuman() {
        setHumanParameter();
        return human;
    }

    public void setHuman(Human human) {
        this.human = human;
    }
}
