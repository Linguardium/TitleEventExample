package mod.linguardium.titleeventexample;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;

public class TitleEventExampleClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// Register a callback for the event. every time the event fires, it runs the method that you register
		TitleMessageEvents.SET_TITLE.register((text, isSubTitle) -> {
			// if the title being set is not a subtitle, and the player exists, add the title to the chat hud
			if (!isSubTitle && MinecraftClient.getInstance().player != null) {
				MinecraftClient.getInstance().player.sendMessage(text);
			}
		});
	}
}