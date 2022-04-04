package gui;

public class LoadButton extends Button
{
    public LoadButton(String buttonName) {
        super(buttonName);
    }

    @Override
    public void useButton()
    {
        System.out.println("Load!");
    }
}