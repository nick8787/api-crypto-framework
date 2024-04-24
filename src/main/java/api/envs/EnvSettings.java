package api.envs;

public class EnvSettings {
    public static void setBaseUrls() {
        System.setProperty("baseBLOCKIOUrl", "https://block.io/api/v2");
    }
}
