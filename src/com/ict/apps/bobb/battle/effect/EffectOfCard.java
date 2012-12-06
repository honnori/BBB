package com.ict.apps.bobb.battle.effect;


import java.util.ArrayList;

import com.ict.apps.bobb.battle.player.IdeaForSelectSpeCard;
import com.ict.apps.bobb.battle.player.Player;
import com.ict.apps.bobb.bobbactivity.BattleCardView;
import com.ict.apps.bobb.data.SpecialCard;

/**
 * 特殊カードの効果実装する抽象クラス
 *
 */
public abstract class EffectOfCard {


	/**
	 * 効果IDが一致したインスタンスを返却する。
	 * @param effectId
	 * @return
	 */
	public static EffectOfCard getEffectInstance(SpecialCard card) {
		
		EffectOfCard returnValue = null;
		int effectId = card.getEffectId();
		
		switch (effectId) {
		case 1:		// ライフポイント回復
			returnValue = new EffectLifeRecovery();
			break;
		default:
			// 想定外の効果ID。エラー。
			break;
		}
		
		return returnValue;
	}
	
	/**
	 * 効果を実装する。
	 */
	public abstract void execEffect(Player userInfo, Player enemyInfo);
	
	

}
