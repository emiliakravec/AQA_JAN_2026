package org.prog.session4;

public class HomeWork4 {

    public static void main(String[] args) {
        String[] emails = new String[]{
                "abcdefg@gmail.com",
                "a@gmail.com",
                "josh@@gmail.com",
                "janegmail.com",
                "pete@gmail.com",
                "zoe@gmailcom",
                "steve@outlook.com",
                "abcd@a.a",
                "abcd.a@fakemail"
        };

        for (int i = 0; i < emails.length; i++) {

            String email = emails[i];

            int firstAt = email.indexOf("@");
            int lastAt = email.lastIndexOf("@");

            if (firstAt == -1 || firstAt != lastAt) {
                continue;
            }

            if (firstAt < 3) {
                continue;
            }

            String domain = email.substring(firstAt + 1);

            int dotIndex = domain.indexOf(".");

            if (dotIndex == -1) {
                continue;
            }

            if (dotIndex == 0 || dotIndex == domain.length() - 1) {
                continue;
            }

            System.out.println(email);
        }

    }
}