package org.sda.homeworks;

public class Dog {

    private String Name;

    private int age;

    private String yieldVoice;

    public Dog(String name, int age, String yieldVoice) {
        Name = name;
        this.age = age;
        this.yieldVoice = yieldVoice;
    }

    public String getYieldVoice() {
        return yieldVoice;
    }

    public void setYieldVoice(String yieldVoice) {
        this.yieldVoice = yieldVoice;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
