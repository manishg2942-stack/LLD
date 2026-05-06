package CreationalDesginPattern.PrototypeDesginPattern;
interface DocumentPrototype {

    DocumentPrototype cloneDocument();
}

class Resume implements DocumentPrototype {

    private String name;
    private String format;

    public Resume(String name, String format) {

        this.name = name;
        this.format = format;
    }

    // Copy constructor
    public Resume(Resume target) {

        this.name = target.name;
        this.format = target.format;
    }

    @Override
    public DocumentPrototype cloneDocument() {

        return new Resume(this);
    }

    public void show() {

        System.out.println(
            "Resume Name: " + name +
            ", Format: " + format
        );
    }

    public void setName(String name) {
        this.name = name;
    }
}
public class PrototypeDesgin {
    public static void main(String[] args) {
        Resume originalResume = new Resume("John Doe", "PDF");
        System.out.println("Original Resume:");
        originalResume.show();

        // Cloning the original resume
        Resume clonedResume = (Resume) originalResume.cloneDocument();
        System.out.println("\nCloned Resume:");
        clonedResume.show();

        // Modifying the cloned resume
        clonedResume.setName("Jane Doe");
        System.out.println("\nModified Cloned Resume:");
        clonedResume.show();

        System.out.println("\nOriginal Resume after modification to clone:");
        originalResume.show();
    }
}
