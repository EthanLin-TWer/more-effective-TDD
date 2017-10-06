import * as assert from 'assert'
import France from '../../src/multi-currency/France'

it('multiplication', () => {
  assert(new France(5).times(2).equals(new France(10)))
  assert(new France(5).times(3).equals(new France(15)))
})

it('money equality', () => {
  assert(new France(5).equals(new France(5)))
  assert.equal(new France(5).equals(new France(4)), false)
  assert.equal(new France(5).equals(null), false)
})
