package moe.kurenai.demo;

public class Main {
    public static void main(String[] args) {
        var activationManager = new ActivationManager();
        activationManager.load();
        System.out.println(activationManager.isActivated());
    }
}
