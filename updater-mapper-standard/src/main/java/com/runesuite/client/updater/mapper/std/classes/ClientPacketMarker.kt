package com.runesuite.client.updater.mapper.std.classes

import com.runesuite.mapper.IdentityMapper
import com.runesuite.mapper.OrderMapper
import com.runesuite.mapper.annotations.DependsOn
import com.runesuite.mapper.annotations.SinceVersion
import com.runesuite.mapper.extensions.Predicate
import com.runesuite.mapper.extensions.predicateOf
import com.runesuite.mapper.tree.Class2

@SinceVersion(157)
@DependsOn(ClientPacket::class)
class ClientPacketMarker : IdentityMapper.Class() {

    override val predicate = predicateOf<Class2> { klass<ClientPacket>().interfaces.contains(it.type) }
}