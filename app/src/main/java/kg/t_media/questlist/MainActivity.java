package kg.t_media.questlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class MainActivity extends AppCompatActivity {

    final String SESSION_ID = "EB2496887D7A4BEE9505FE03630C71FD";
    final String PLAYER_ID = "126";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyApi api = MyClient.getMyApi();
        final Call<QuestResult> questResult = api.questList(PLAYER_ID, SESSION_ID, "0");
        questResult.enqueue(new Callback<QuestResult>() {
            @Override
            public void onResponse(Call<QuestResult> call, Response<QuestResult> response) {
                if (response.isSuccessful()) {

                        Integer status = response.body().getStatus();
                        String message = response.body().getMessage();
                        List<QuestResult.DataQ> questData = response.body().getDataq();

                        QuestResult.DataQ quest;
                        for (int i = 0; i < questData.size(); i++) {
                            quest = questData.get(i);
                            String categoryId = quest.getQuestId();
                            String categoryName = quest.getQuestName();
                        }



                } else {

                }
            }
            @Override
            public void onFailure(Call<QuestResult> call, Throwable t) {

            }
        });


    }
}
