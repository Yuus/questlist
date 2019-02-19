package kg.t_media.questlist;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MyApi {
    @GET("quests/questList.php")
    Call<QuestResult> questList(@Query("playerId") String playerId, @Query("sessionId") String SessionId, @Query("questId") String questId);



}
