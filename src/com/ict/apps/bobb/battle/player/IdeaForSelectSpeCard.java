package com.ict.apps.bobb.battle.player;

import java.util.ArrayList;


import com.ict.apps.bobb.bobbactivity.BattleCardView;
import com.ict.apps.bobb.data.Card;

/**
 * 特殊カードを選択するための判断クラス（抽象クラス）
 *
 */
public abstract class IdeaForSelectSpeCard {
	
	// 効果カード種別
	public static final int EFFECTID_LP_RECOVER = 10;
	public static final int EFFECTID_DOUBLE_ATTACK = 1;

	private IdeaForSelectSpeCard next = null;
	
	/**
	 * 次案取得
	 */
	public IdeaForSelectSpeCard getNext() {
		return this.next;
	}
	
	public IdeaForSelectSpeCard setNext(IdeaForSelectSpeCard next) {
		this.next = next;
		return next;
	}
	
	/**
	 * 使用するカードを選択する
	 * @return 効果ID
	 */
	public ArrayList<BattleCardView> choiceCard(Player userInfo, Player enemyInfo) {

		ArrayList<BattleCardView> cards = this.judge(userInfo, enemyInfo);

		if(cards == null) {
			if (this.next != null) {
				cards = this.next.choiceCard(userInfo, enemyInfo);
			}
		}
		return cards;
	}
	
	/**
	 * アイデア採用時には効果対象のを返す
	 * @return
	 */
	protected abstract ArrayList<BattleCardView> judge(Player userInfo, Player enemyInfo);
	

}
