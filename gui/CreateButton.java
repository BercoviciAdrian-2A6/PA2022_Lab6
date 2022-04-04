package gui;

public class CreateButton extends Button
{

    public CreateButton(String buttonName) {
        super(buttonName);
    }

    @Override
    public void useButton()
    {
        System.out.println("Create!");
    }
}
