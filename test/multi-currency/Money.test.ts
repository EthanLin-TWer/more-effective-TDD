import * as assert from 'assert'
import Dollar from '../../src/multi-currency/Dollar'
import France from '../../src/multi-currency/France'

describe('get class name', () => {
  it('should return Dollar when getClassName() is called on a dollar instance', () => {
    assert.equal(new Dollar(5).getClassName(), 'Dollar')
  })

  it('should return France when getClassName() is called on a france instance', () => {
    assert.equal(new France(5).getClassName(), 'France')
  })
})

it('should return false when comparing $5 and CHF5', () => {
  const fiveDollars = new Dollar(5)
  const fiveFrances = new France(5)

  assert.equal(fiveDollars.equals(fiveFrances), false)
})
