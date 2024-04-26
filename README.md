[![Modrinth](https://raw.githubusercontent.com/Prospector/badges/master/modrinth-badge-72h-padded.png)](https://modrinth.com/mod/hopperpots)

![Diagram of the mods functionality](https://cdn.modrinth.com/data/VC49Z5ik/images/d733e48ff96eb2c174035fff05dd4186e20cd4c2.png)

# How it works
Hoppers check for blocks with the `#c:hopper_special_blocks` **(the Decorated Pot is in this block tag by default)** below them and if there is one they try to push items into it.

## GameRule
You can disable the hopper behavior by setting the `hopperSpecialBlocks` gamerule to `false`.

## Dependencies
- [FabricAPI](https://modrinth.com/mod/fabric-api)
- [Nixienaut](https://modrinth.com/mod/Nixienaut)
