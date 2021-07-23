package live.hms.hmssdk_flutter

import live.hms.video.sdk.models.HMSPeer
import live.hms.video.sdk.models.enums.HMSPeerUpdate

class HMSPeerExtension {

    companion object{
        fun toDictionary(peer:HMSPeer?):HashMap<String,Any?>?{
            val args=HashMap<String,Any?>()

            if (peer==null)return null
            args.put("peer_id",peer.peerID)
            args.put("name",peer.name)
            args.put("is_local",peer.isLocal)
            args.put("role",HMSRoleExtension.toDictionary(peer.hmsRole))
            args.put("customer_description",peer.customerDescription)
            args.put("customer_user_id",peer.customerUserID)
            //args.put("status", getValueofHMSPeerUpdate(update))

            args.put("audio_track", HMSTrackExtension.toDictionary(peer.audioTrack))

            args.put("video_track", HMSTrackExtension.toDictionary(peer.videoTrack))


            return args
        }

        fun getValueofHMSPeerUpdate(update:HMSPeerUpdate?):String?{
            if(update==null)return null
            return when(update){
                HMSPeerUpdate.PEER_JOINED-> "peerJoined"
                HMSPeerUpdate.PEER_LEFT-> "peerLeft"
                HMSPeerUpdate.AUDIO_TOGGLED-> "audioToggled"
                HMSPeerUpdate.VIDEO_TOGGLED-> "videoToggled"
                else-> "defaultUpdate"
            }
        }


    }
}