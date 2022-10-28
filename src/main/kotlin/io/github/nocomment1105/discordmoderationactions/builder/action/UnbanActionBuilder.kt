/*
 * Copyright (c) 2022 NoComment1105 <nocomment1105@outlook.com>
 *
 * This file is part of discord-moderation-actions.
 *
 * Licensed under the MIT license. For more information,
 * please see the LICENSE file or https://mit-license.org/
 */

package io.github.nocomment1105.discordmoderationactions.builder.action

import dev.kord.core.entity.channel.GuildMessageChannel
import dev.kord.rest.builder.message.EmbedBuilder
import io.github.nocomment1105.discordmoderationactions.annotations.ActionBuilderDSL
import io.github.nocomment1105.discordmoderationactions.builder.RemoveAction
import io.github.nocomment1105.discordmoderationactions.enums.PrivateLogResult

@ActionBuilderDSL
public open class UnbanActionBuilder : RemoveAction {
	/** Whether to send a message to the action log provided. Default: True. */
	public override var sendActionLog: Boolean = true

	/** The reason for the action. */
	public override var reason: String? = "No Reason provided"

	/** The channel to send the [actionEmbed] too. */
	public override var loggingChannel: GuildMessageChannel? = null

	/** The result of the attempt to send a private action log. */
	public override lateinit var privateLogResult: PrivateLogResult

	/**
	 * Whether the bot has permission the required permissions to use the logging channel. This should be evaluated
	 * by a check system from within the bot and passed into this variable.
	 */
	public override var hasLogChannelPerms: Boolean? = null

	/** @suppress Builder that shouldn't be set directly by the user. */
	public override var actionEmbedBuilder: (suspend EmbedBuilder.() -> Unit)? = null
}
