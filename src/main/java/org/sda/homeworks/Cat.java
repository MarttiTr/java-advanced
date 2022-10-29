package org.sda.homeworks;

public class Cat extends Animal{

   private String Name;

   private int age;

   private String yieldVoice;

    public Cat(String name, int age, String yieldVoice) {
        Name = name;
        this.age = age;
        this.yieldVoice = yieldVoice;
    }

    public Cat(String yieldVoice) {
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

    public String getYieldVoice() {
        return yieldVoice;
    }

    public void setYieldVoice(String yieldVoice) {
        this.yieldVoice = yieldVoice;
    }
}
