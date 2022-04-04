package gui;

public class SaveButton extends Button
{
    public SaveButton(String buttonName) {
        super(buttonName);
    }

    @Override
    public void useButton()
    {
        System.out.println("Save!");
    }
}
