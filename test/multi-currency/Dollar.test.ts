import * as assert from 'assert'
import Dollar from '../../src/multi-currency/Dollar'

it('multiplication', () => {
  assert(new Dollar(5).times(2).equals(new Dollar(10)))
  assert(new Dollar(5).times(3).equals(new Dollar(15)))
})

it('money equality', () => {
  assert(new Dollar(5).equals(new Dollar(5)))
  assert.equal(new Dollar(5).equals(new Dollar(4)), false)
  assert.equal(new Dollar(5).equals(null), false)
})
