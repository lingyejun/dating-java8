package com.lingyejun.dating.chap4;

/**
 * @Author: lingyejun
 * @Date: 2019/11/10
 * @Describe:
 * @Modified By:
 */
public class Student {

    private String name;

    private String sex;

    private String phoneNumber;

    public Student(String name, String sex, String phoneNumber) {
        this.name = name;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
    }

    public static class StudentBuilder {

        private String name;

        private String sex;

        private String phoneNumber;

        public StudentBuilder name(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder sex(String sex) {
            this.sex = sex;
            return this;
        }

        public StudentBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Student build() {
            return new Student(this.name, this.sex, this.phoneNumber);
        }
    }


    public static void main(String[] args) {
        Student student = new StudentBuilder().
                name("Jack").
                sex("man").
                phoneNumber("123").
                build();
        System.out.println(student.name);
    }
}
