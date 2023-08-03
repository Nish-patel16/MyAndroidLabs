package algonquin.cst2335.pate1088;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import algonquin.cst2335.pate1088.databinding.DetailsLayoutBinding;

public class MessageDetailsFragment extends Fragment {

    ChatMessage selected;
    private TextView messageText;
    private TextView timeText;
    private TextView sendReceiveText;
    private TextView databaseText;

    public MessageDetailsFragment(ChatMessage m){
        selected = m;
    }

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        DetailsLayoutBinding binding = DetailsLayoutBinding.inflate(inflater);

        binding.messageText.setText( selected.message );
        binding.timeText.setText( selected.timeSent );
        binding.databaseText.setText( "Id = " + selected.id );

        return binding.getRoot();
    }
    public void displayMessage(ChatMessage message) {
        if (message != null) {
            messageText.setText(message.getMessage());
            timeText.setText(message.getTimeSent());

            if (message.isSentButton()) {
                sendReceiveText.setText("Sent"); // Assuming "Sent" is the appropriate text for a sent message
            } else {
                sendReceiveText.setText("Received"); // Assuming "Received" is the appropriate text for a received message
            }

            databaseText.setText("Database ID: " + message.getId());
        }
    }
}