-- 分布式ID，如果redis集群的话，如：5台，该脚本的自增可以id+1 id+2、id+3 。。。，分别向5台机器加载该脚本
local key = KEYS[1]
local id = redis.call('get',key)
if(id == false)
then
    redis.call('set',key,1)
    return key.."0001"
else
    redis.call('set',key,id+1)
    return key..string.format('%04d',id + 1)
end