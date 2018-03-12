import groovy.transform.TailRecursive

@TailRecursive
def factorial(n, acc = 1) {
    n <= 1 ? acc : factorial(n - 1, n * acc)
}

println factorial(1000G)

/*
    @groovy.transform.TailRecursive
    public java.lang.Object factorial(java.lang.Object n, java.lang.Object acc = 1) {
        java.lang.Object _acc_ = acc
        java.lang.Object _n_ = n
        while (true) {
            _RECUR_HERE_:
            try {
                if ( _n_ <= 1) {
                    return _acc_
                } else {
                    null:
                    {
                        java.lang.Object __n__ = _n_
                        java.lang.Object __acc__ = _acc_
                        _n_ = __n__ - 1
                        _acc_ = __n__ * __acc__
                        continue _RECUR_HERE_
                    }
                }
            }
            catch (org.codehaus.groovy.transform.tailrec.GotoRecurHereException ignore) {
                continue _RECUR_HERE_
            }
            finally {
            }
        }
    }

 */
