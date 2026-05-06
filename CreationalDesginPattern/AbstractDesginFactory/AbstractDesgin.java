package CreationalDesginPattern.AbstractDesginFactory;
interface StorageService {
    void uploadFile(String fileName);
}

interface DatabaseService {
    void connect();
}

class AWSStorageService implements StorageService {

    @Override
    public void uploadFile(String fileName) {

        System.out.println(
            "Uploading " + fileName + " to AWS S3"
        );
    }
}

class AWSDatabaseService implements DatabaseService {

    @Override
    public void connect() {

        System.out.println(
            "Connecting to AWS RDS"
        );
    }
}

class AzureStorageService implements StorageService {

    @Override
    public void uploadFile(String fileName) {

        System.out.println(
            "Uploading " + fileName + " to Azure Blob"
        );
    }
}

class AzureDatabaseService implements DatabaseService {

    @Override
    public void connect() {

        System.out.println(
            "Connecting to Azure SQL"
        );
    }
}
interface CloudFactory {

    StorageService createStorageService();

    DatabaseService createDatabaseService();
}

class AWSFactory implements CloudFactory {

    @Override
    public StorageService createStorageService() {
        return new AWSStorageService();
    }

    @Override
    public DatabaseService createDatabaseService() {
        return new AWSDatabaseService();
    }
}

class AzureFactory implements CloudFactory {

    @Override
    public StorageService createStorageService() {
        return new AzureStorageService();
    }

    @Override
    public DatabaseService createDatabaseService() {
        return new AzureDatabaseService();
    }
}
public class AbstractDesgin {
    public static void main(String[] args) {
        CloudFactory awsFactory = new AWSFactory();
        StorageService awsStorage = awsFactory.createStorageService();
        DatabaseService awsDatabase = awsFactory.createDatabaseService();

        awsStorage.uploadFile("file.txt");
        awsDatabase.connect();

        CloudFactory azureFactory = new AzureFactory();
        StorageService azureStorage = azureFactory.createStorageService();
        DatabaseService azureDatabase = azureFactory.createDatabaseService();

        azureStorage.uploadFile("file.txt");
        azureDatabase.connect();
}
}