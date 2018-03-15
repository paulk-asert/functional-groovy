//@Grab('one.util:streamex:0.6.6')
import one.util.streamex.StreamEx
import java.util.function.Function
import static StreamExUtil.batches

def s = [2, 5, 3, 2, 0, 2]
Function pow = { exponent, base -> base ** exponent }
assert [1, 8, 25] == StreamEx.of(s).chain(batches(2)).map(pow).toList().reverse()
