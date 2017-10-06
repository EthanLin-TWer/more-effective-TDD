import * as assert from 'assert'
import Dollar from '../../src/multi-currency/Dollar'
import Money from '../../src/multi-currency/Money'

it('multiplication', () => {
  assert(Money.dollar(5).times(2).equals(Money.dollar(10)))
  assert(Money.dollar(5).times(3).equals(Money.dollar(15)))
})

it('money equality', () => {
  assert(new Dollar(5).equals(new Dollar(5)))
  assert.equal(new Dollar(5).equals(new Dollar(4)), false)
  assert.equal(new Dollar(5).equals(null), false)
})
