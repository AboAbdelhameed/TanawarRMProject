package apis;


/**
 *
 */
public class UserAPI {
    /**
     *
     */
    private static UserAPI userAPI;
    /**
     *
     */
    /**
     *
     * @return
     */
    public static UserAPI getInstance(){
        if(userAPI == null)
            userAPI = new UserAPI();
        return userAPI;
    }
    /**
     *
     */
    private UserAPI(){
        //Firestore db = FirestoreClient.get
    }
}
