trigger TCases on Case (before insert) {
	CCaseTriggerHandler handler = new CCaseTriggerHandler();

	if (Trigger.isBeforeInsert) {
		handler.beforeInsert(Trigger.new)
	}
}