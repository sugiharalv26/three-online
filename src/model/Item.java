package model;

import java.util.Date;

/**
 * 物品情報
 *
 * @author Three-in
 */
public class Item {
	/** 物品ID */
	private String itemId;
	/** 物品名 */
	private String itemName;
	/** 物品ジャンル */
	private String itemGenre;
	/** 物品配給 */
	private String itemPublisher;
	/** 物品公開日 */
	private Date itemArrivalDate;
	/** 物品画像パス */
	private String itemImgPath;
	/** 物品コメント */
	private String itemComment;
	/** 削除フラグ */
	private String deleteFlg;
	/** 登録日付 */
	private Date insertDate;
	/** 更新日付 */
	private Date updateDate;

	/**
	 * 物品IDを返却する。
	 * @param itemId 物品ID
	 */
	public String getItemId() {
		return this.itemId;
	}

	/**
	 * 物品名を返却する。
	 * @param itemName 物品名
	 */
	public String getItemName() {
		return this.itemName;
	}

	/**
	 * 物品ジャンルを返却する。
	 * @param itemGenre 物品ジャンル
	 */
	public String getItemGenre() {
		return this.itemGenre;
	}

	/**
	 * 物品配給を返却する。
	 * @param itemPublisher 物品配給
	 */
	public String getItemPublisher() {
		return this.itemPublisher;
	}

	/**
	 * 物品公開日を返却する。
	 * @param itemArrivalDate 物品公開日
	 */
	public Date getItemArrivalDate() {
		return this.itemArrivalDate;
	}

	/**
	 * 物品画像パスを返却する。
	 * @param itemImgPath 物品画像パス
	 */
	public String getItemImgPath() {
		return this.itemImgPath;
	}

	/**
	 * 物品コメントを返却する。
	 * @param itemComment 物品コメント
	 */
	public String getItemComment() {
		return this.itemComment;
	}

	/**
	 * 削除フラグを返却する。
	 * @param deleteFlg 削除フラグ
	 */
	public String getDeleteFlg() {
		return this.deleteFlg;
	}

	/**
	 * 登録日付を返却する。
	 * @param insertDate 登録日付
	 */
	public Date getInsertDate() {
		return this.insertDate;
	}

	/**
	 * 更新日付を返却する。
	 * @param updateDate 更新日付
	 */
	public Date getUpdateDate() {
		return this.updateDate;
	}

	/**
	 * 物品IDを設定する。
	 * @param itemId 物品ID
	 */
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	/**
	 * 物品名を設定する。
	 * @param itemName 物品名
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * 物品ジャンルを設定する。
	 * @param itemGenre 物品ジャンル
	 */
	public void setItemGenre(String itemGenre) {
		this.itemGenre = itemGenre;
	}

	/**
	 * 物品配給を設定する。
	 * @param itemPublisher 物品配給
	 */
	public void setItemPublisher(String itemPublisher) {
		this.itemPublisher = itemPublisher;
	}

	/**
	 * 物品公開日を設定する。
	 * @param itemArrivalDate 物品公開日
	 */
	public void setItemArrivalDate(Date itemArrivalDate) {
		this.itemArrivalDate = itemArrivalDate;
	}

	/**
	 * 物品画像パスを設定する。
	 * @param itemImgPath 物品画像パス
	 */
	public void setItemImgPath(String itemImgPath) {
		this.itemImgPath = itemImgPath;
	}

	/**
	 * 物品コメントを設定する。
	 * @param itemComment 物品コメント
	 */
	public void setItemComment(String itemComment) {
		this.itemComment = itemComment;
	}

	/**
	 * 削除フラグを設定する。
	 * @param deleteFlg 削除フラグ
	 */
	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	/**
	 * 登録日付を設定する。
	 * @param insertDate 登録日付
	 */
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	/**
	 * 更新日付を設定する。
	 * @param updateDate 更新日付
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
