package pal.thetuar.figuraoverchanged.mixins;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.event.RenderPlayerEvent;
import org.figuramc.figura.avatar.Avatar;
import org.figuramc.figura.avatar.AvatarManager;
import org.figuramc.figura.permissions.Permissions;
import org.spongepowered.asm.mixin.Mixin;
import net.ltxprogrammer.changed.client.EventHandlerClient;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EventHandlerClient.class)
public class thirdperson {
    @Inject(method = "onRenderPlayerPre", at = @At("HEAD"), cancellable = true, remap=false)
    private void onRenderPlayerPre(RenderPlayerEvent.Pre event, CallbackInfo ci) {
        Player player = event.getPlayer();
        Avatar avatar = AvatarManager.getAvatar(player);
        if (avatar != null && avatar.permissions.get(Permissions.OFFSCREEN_RENDERING) == 1)
            ci.cancel();
    }
}
